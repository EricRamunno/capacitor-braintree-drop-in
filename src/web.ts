import { WebPlugin } from '@capacitor/core';

import type { BraintreeDropInPlugin, DropInOptions } from './definitions';

export class BraintreeDropInWeb extends WebPlugin implements BraintreeDropInPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  showDropIn(options: DropInOptions): Promise<any> {
    console.log('LOG: ', options);
    return Promise.resolve(undefined);
  }
}
