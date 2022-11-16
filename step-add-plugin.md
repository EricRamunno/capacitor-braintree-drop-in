## Step Plugin Capacitor-Braintree-drop-in

1. cp plugin source-code (capacitor-braintree-drop-ing) nella cartella src/plugin dell'app
2. All'interno della cartella dell'app eseguire il seguente comando:

```

npm install @capacitor/core@4.1.0
npm install ./src/plugins/capacitor-braintree-drop-in

```

3. Sincronizzare ionic e il progetto github:

```
npx ionic build && npx cap copy
npx cap sync


```

4. All'interno della cartella di ios dell app ( mia-app/ios/App ) lanciare il seguente comando:

```

pod install

```


5. Aprire l'app con XCode 
