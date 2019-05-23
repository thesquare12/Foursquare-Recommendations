# Foursquare-Recommendations
Foursquare demo app using open API

## Usage
### Set your own API keys
Set client id, client secret in Constants.kt
```kotlin
const val CLIENT_ID = "YOUR-CLIENT-ID"
const val CLIENT_SECRET = "YOUR-CLIENT-SECRET"
```
Register your app and get API keys here : https://developer.foursquare.com/

## Restriction
Image url is hard-coded because the photo API has a limit of 50 API calls per day.

## Libraries used
* Data Binding
* Lifecycles
* LiveData
* Navigation
* ViewModel
* Glide
* Retrofit
