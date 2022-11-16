import { WebPlugin } from '@capacitor/core';
import type { BraintreeDropInPlugin, DropInOptions } from './definitions';
export declare class BraintreeDropInWeb extends WebPlugin implements BraintreeDropInPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    showDropIn(options: DropInOptions): Promise<any>;
}
