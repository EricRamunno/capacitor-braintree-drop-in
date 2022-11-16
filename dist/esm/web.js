import { WebPlugin } from '@capacitor/core';
export class BraintreeDropInWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    showDropIn(options) {
        console.log('LOG: ', options);
        return Promise.resolve(undefined);
    }
}
//# sourceMappingURL=web.js.map