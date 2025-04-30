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

- Java 17
- Spring Boot 3.x
- Spring Security
- JWT (JJWT library)
- Hibernate / JPA
- PostgreSQL
- Lombok
- MapStruct
- Maven

---

## 🛠️ Nasıl Çalıştırılır?

### 1. Gereksinimler

- Java 17+
- Maven
- PostgreSQL

### 2. Veritabanı Kurulumu

```sql
CREATE DATABASE smartappointment;