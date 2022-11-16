export interface BraintreeDropInPlugin {
  showDropIn(options: DropInOptions): Promise<any>;
}

export interface DropInOptions {
  paymentToken: string,
  amount: number,
  givenName: string,
  surname: string,
  email: string
}
