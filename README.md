# Android Intent Demo Application

A simple Android application written in **Java** that demonstrates how to use Implicit Intents to interact with other applications on an Android device (Google Chrome, Google Maps, Phone Dialer, and the system Share Sheet).

## 🚀 Features

The application features four main input fields and corresponding buttons to trigger the following actions:

*   **Open Web Pages:** Enter a URL that opens directly in **Google Chrome** using `Intent.ACTION_VIEW` (with an automatic fallback to `https://` if missing).
*   **Find Locations:** Enter any location name or address to open it directly inside **Google Maps** using a geographic URI scheme (`geo:0,0?q=`).
*   **Share Text:** Enter custom text and share it across other apps (e.g., Messages, Email, WhatsApp) using a system chooser powered by `ShareCompat.IntentBuilder`.
*   **Dial Phone Numbers:** Enter a phone number to open the native system dialer with the number pre-filled using `Uri.parse("tel:...")` and `Intent.ACTION_DIAL`.

## 🛠️ Technical Details

*   **Language:** Java
*   **Minimum SDK:** Android 5.0 (API 21) or higher
*   **Core Concepts:**
    *   `EdgeToEdge` layout integration for full-screen UI support.
    *   `Uri.parse()` to seamlessly convert string inputs into data URIs.
    *   `intent.setPackage()` targeting specific apps (Chrome and Maps) with automatic system fallbacks.

## ⚙️ Installation & Setup

1. Clone or download this repository.
2. Open the project folder in **Android Studio**.
3. Wait for the Gradle synchronization to finish.
4. Run the project on an emulator or a connected physical Android device.

## Screenshots

<img width="200" height="400" alt="Posnetek zaslona 2026-11-16 100006" src="https://github.com/user-attachments/assets/5dd82251-04b5-4622-9d11-cf1c17c11aa0" />
<img width="200" height="400" alt="Posnetek zaslona 2026-11-16 100356" src="https://github.com/user-attachments/assets/238113e5-f24a-4ca4-a1c2-f0dcb0e6bf9c" />
<img width="200" height="400" alt="Posnetek zaslona 2026-11-16 100321" src="https://github.com/user-attachments/assets/82f7869a-9153-47bd-bf57-95d081b6c378" />
<img width="200" height="400" alt="Posnetek zaslona 2026-11-16 100209" src="https://github.com/user-attachments/assets/7b1964d8-c658-4aa8-a5c1-f36167b31f79" />
<img width="200" height="400" alt="Posnetek zaslona 2026-11-16 100121" src="https://github.com/user-attachments/assets/49ee250d-63fb-40cd-b68a-6f93f364c511" />
