# Mobile Automation Test - QA Bootcamp

## Reflection Questions

### 1. Critical Path Automation
Skenario paling kritikal adalah **Login** dan **Add to Cart**. Login penting karena tanpa akses ke aplikasi, semua fitur lain tidak bisa diuji. Add to Cart kritikal karena itu inti dari alur belanja—kalau gagal, user tidak bisa checkout. Risiko jika login gagal: user tidak bisa masuk, automation berhenti di awal. Risiko jika add-to-cart gagal: transaksi tidak bisa dilakukan, revenue hilang. Kedua skenario ini memastikan aplikasi stabil di jalur utama (critical path).

### 2. Locator & Stabilitas Testing
Saat menggunakan Appium Inspector, ada elemen yang sulit diidentifikasi karena hanya punya `index` atau `instance`. Locator seperti ini rawan berubah jika UI diupdate. Pertimbangan saya adalah memilih locator yang paling stabil: `resourceId` atau `accessibilityId`. Dengan locator stabil, test lebih reliable dan tidak flakey. Kalau locator tidak konsisten, automation sering gagal meski aplikasi normal. Jadi pemilihan locator langsung memengaruhi keandalan test.

### 3. Kendala Hardware
Selain kendala locator, saya juga mengalami kesulitan saat menjalankan test di device asli. Kabel USB kadang tidak stabil, sehingga koneksi ADB putus di tengah jalan. Hal ini membuat test gagal bukan karena script, tapi karena hardware. Risiko dari kendala ini adalah hasil run tidak konsisten. Untuk mengatasinya, saya memastikan kabel dan port USB dalam kondisi baik, serta menggunakan device asli karena emulator terlalu lambat. Ini pengalaman nyata yang memengaruhi stabilitas eksekusi automation.

---

## Setup Project
- Framework: **Java + Gradle + TestNG + Appium**
- IDE: **IntelliJ IDEA**
- Device: **Android real device (API 33)**
- Demo App: `saucedemo.apk`

### Dependencies
Tambahkan di `build.gradle`:
```gradle
dependencies {
    testImplementation 'org.testng:testng:7.9.0'
    implementation 'io.appium:java-client:8.5.1'
    implementation 'org.seleniumhq.selenium:selenium-support:4.9.1'
    implementation 'commons-io:commons-io:2.11.0'
}
```

---

## Setup Project

```text
src
├── main
│   └── java
│       ├── core
│       │   ├── DriverManager.java
│       │   └── BasePage.java
│       └── page
│           ├── LoginPage.java
│           └── ProductPage.java
├── test
│   ├── java
│   │   ├── core
│   │   │   ├── BaseTest.java
│   │   │   └── TestListener.java
│   │   └── tests
│   │       ├── LoginTest.java
│   │       └── AddToCartTest.java
│   └── resources
│       └── suites
│           └── smoke.xml
```
---

## Cara Run
1. Jalankan Appium server di PC.
2. Hubungkan device Android asli via USB (aktifkan USB debugging).
3. Pastikan APK sudah ada di folder apk/.
4. Run smoke.xml via IntelliJ atau command:
```bash
.\gradlew test
```
5. Hasil run: log di console + screenshot otomatis jika test gagal.

---
## Evidence
- Screen record run smoke.xml di device asli.
- Screenshot otomatis dari listener saat test gagal.

![Screenshot Hasil Run](docs/screenshot-run.png)

