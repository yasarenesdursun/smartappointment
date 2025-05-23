# 🔐 SmartAppointment – Spring Boot JWT Authentication API

Bu proje, Spring Boot kullanılarak geliştirilmiş tam işlevli bir **JWT tabanlı kullanıcı kimlik doğrulama sistemidir.**
Amaç; kullanıcı kayıt, login, logout ve kimlik doğrulama işlemlerini RESTful olarak yönetebilen bir backend mimarisi sunmaktır.

---

## 🚀 Özellikler

✅ Kullanıcı Kayıt (`/api/auth/register`)
✅ Kullanıcı Giriş (`/api/auth/login`)
✅ JWT Token üretimi ve doğrulama
✅ Token veritabanı takibi (revoke & expire)
✅ Çıkış (logout) işlemi (`/api/auth/logout`)
✅ Token ile korunan endpoint (`/api/user/me`)
✅ Şifre güvenliği (BCrypt hashing)
✅ DTO dönüşümleri ve veri gizliliği
✅ MapStruct ile temiz model dönüşümü
✅ Spring Security ile full yetkilendirme

---

## 📦 Kullanılan Teknolojiler

* Java 17
* Spring Boot 3.x
* Spring Security
* JWT (JJWT library)
* Hibernate / JPA
* PostgreSQL
* Lombok
* MapStruct
* Maven

---

## 🛠️ Nasıl Çalıştırılır?

### 1. Gereksinimler

* Java 17+
* Maven
* PostgreSQL

### 2. Veritabanı Kurulumu

```sql
CREATE DATABASE smartappointment;
```

### 3. application.properties Ayarları

```properties
# PostgreSQL DB
spring.datasource.url=jdbc:postgresql://localhost:5432/smartappointment
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Swagger
springdoc.api-docs.enabled=true

# JWT
jwt.secret=your-256-bit-secret
jwt.expiration=3600000
```

---

## 🔒 Ortam Değişkenleri (env)

Projeyi çalıştırırken şu değişkenleri sistem ortamına tanımlayabilirsiniz:

| Değişken Adı | Açıklama | Örnek |
|--------------|----------|--------|
| JWT_SECRET | JWT token'ların imzalanmasında kullanılan gizli anahtar | `my-prod-secret-123` |
| DB_PASSWORD | PostgreSQL kullanıcı şifresi | `123456` |

## 🧪 Swagger UI ile Test

📍 Swagger'a erişim için:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### ✍️ JWT Token ile Yetkili Test

1. `/api/auth/register` → Yeni kullanıcı oluştur
2. `/api/auth/authenticate` → JWT token al
3. Swagger'da `Authorize` butonuna tıkla, sadece token'ı (Bearer yazmadan) gir
4. `/api/user/me` gibi korunan endpoint'leri test et

---

## 👥 Rol Bazlı Erişim

| Endpoint               | Gereken Rol     |
| ---------------------- | --------------- |
| `/api/user/me`         | USER veya ADMIN |
| `/api/admin/dashboard` | ADMIN           |

---
