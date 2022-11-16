import { registerPlugin } from '@capacitor/core';

import type { BraintreeDropInPlugin } from './definitions';

const BraintreeDropIn = registerPlugin<BraintreeDropInPlugin>('BraintreeDropIn', {
  web: () => import('./web').then(m => new m.BraintreeDropInWeb()),
});

export * from './definitions';
export { BraintreeDropIn };
