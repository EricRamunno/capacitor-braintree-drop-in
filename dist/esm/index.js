import { registerPlugin } from '@capacitor/core';
const BraintreeDropIn = registerPlugin('BraintreeDropIn', {
    web: () => import('./web').then(m => new m.BraintreeDropInWeb()),
});
export * from './definitions';
export { BraintreeDropIn };
//# sourceMappingURL=index.js.map