#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
// name of hte plugin => BraintreeDropInPlugin
CAP_PLUGIN(BraintreeDropInPlugin, "BraintreeDropIn",
           CAP_PLUGIN_METHOD(showDropIn, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(NativeMethod, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(NotifyListeners, CAPPluginReturnPromise);
)
