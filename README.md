# capacitor-braintree-drop-in

Ionic 6+ & Capacitor 4+ Native Braintree Plugin for Android & iOS

## Install

```bash
npm install capacitor-braintree-drop-in
npx cap sync
```

## API

<docgen-index>

* [`showDropIn(...)`](#showdropin)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### showDropIn(...)

```typescript
showDropIn(options: DropInOptions) => Promise<any>
```

| Param         | Type                                                    |
| ------------- | ------------------------------------------------------- |
| **`options`** | <code><a href="#dropinoptions">DropInOptions</a></code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### Interfaces


#### DropInOptions

| Prop               | Type                |
| ------------------ | ------------------- |
| **`paymentToken`** | <code>string</code> |
| **`amount`**       | <code>number</code> |
| **`givenName`**    | <code>string</code> |
| **`surname`**      | <code>string</code> |
| **`email`**        | <code>string</code> |

</docgen-api>
