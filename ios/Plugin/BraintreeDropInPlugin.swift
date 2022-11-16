import Foundation
import Capacitor
import BraintreeDropIn

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BraintreeDropInPlugin)
public class BraintreeDropInPlugin: CAPPlugin, BTThreeDSecureRequestDelegate{
    public func onLookupComplete(_ request: BTThreeDSecureRequest, lookupResult result: BTThreeDSecureResult, next: @escaping () -> Void) {
    }

    private let implementation = BraintreeDropIn()

    @objc func showDropIn(_ call: CAPPluginCall) {
        let request = BTDropInRequest()
        let threeDSecureRequest = BTThreeDSecureRequest()
        threeDSecureRequest.threeDSecureRequestDelegate = self

        
        threeDSecureRequest.amount = Decimal(call.getDouble("amount") ?? 1.0) as NSDecimalNumber
        threeDSecureRequest.email = call.getString("email") ?? ""
        threeDSecureRequest.versionRequested = .version2

        let address = BTThreeDSecurePostalAddress()
        address.givenName = call.getString("givenName") ?? ""
        address.surname = call.getString("surname") ?? ""
        threeDSecureRequest.billingAddress = address

        let additionalInformation = BTThreeDSecureAdditionalInformation()
        additionalInformation.shippingAddress = address
        threeDSecureRequest.additionalInformation = additionalInformation
        
        request.threeDSecureRequest = threeDSecureRequest
        let dropIn = BTDropInController(authorization: call.getString("paymentToken") ?? "", request: request)
        { (controller, result, error) in
            if (error != nil) {
                call.reject("error")
            } else if (result?.isCanceled == true) {
                call.reject("CANCELED")
            } else if let result = result {
                call.resolve([
                    "nonce": result.paymentMethod?.nonce as Any,
                    "lastFour": result.paymentDescription
                ])
            }
            
            controller.dismiss(animated: true, completion: nil)
        }

        DispatchQueue.main.async {
            self.bridge?.viewController?.present(dropIn!, animated: true, completion: nil)
        }
    }
    
}
