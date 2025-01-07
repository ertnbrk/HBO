<template>
    <div :class="['container', { 'right-panel-active': isSignUp }]" id="container">
      <div class="form-container sign-up-container">
        <form @submit.prevent="signupUser">
          <h1>Hesap Oluştur</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <input v-model="signup.name" type="text" placeholder="Name" />
          <input v-model="signup.email" type="email" placeholder="Email" />
          <input v-model="signup.password" type="password" placeholder="Password" />
          <button type="submit">Kayıt Ol</button>
        </form>
      </div>
      <div class="form-container sign-in-container">
        <form @submit.prevent="signinUser">
          <h1>Giriş yap</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <br>
          <input v-model="signin.email" type="email" placeholder="Email" />
          <input v-model="signin.password" type="password" placeholder="Password" />
          <a href="#">Şifremi unuttum</a>
          <button type="submit">Giriş Yap</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <h1>Aramıza hoşgeldin</h1>
            <p>Hesabını oluştur ve etkinlik takvimini düzenlemeye başla</p>
            <button class="ghost" @click="toggleForm">Giriş Yap</button>
          </div>
          <div class="overlay-panel overlay-right">
            <h1>Hoşgeldin!</h1>
            <p>Etkinliklerini takip etmek için giriş yap</p>
            <button class="ghost" @click="toggleForm">Kayıt Ol</button>
          </div>
        </div>
      </div>
    </div>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

  </template>
  
  <script>
  export default {
    data() {
      return {
        signup: {
          name: '',
          email: '',
          password: '',
        },
        signin: {
          email: '',
          password: '',
        },
        isSignUp: false, // This controls the form toggle
      };
    },
    methods: {
      signupUser() {
        // Handle user signup logic
        console.log('User signed up:', this.signup);
        this.$router.push('/home'); // Örneğin kullanıcıyı /dashboard sayfasına yönlendiriyoruz

      },
      signinUser() {
        // Handle user signin logic
        console.log('User signed in:', this.signin);
        this.$router.push('/home'); // Örneğin kullanıcıyı /home sayfasına yönlendiriyoruz

      },
      toggleForm() {
        // Toggle the form view between sign-in and sign-up
        this.isSignUp = !this.isSignUp;
      },
    },
  };
  </script>
  <style src="../style/login.css"></style>
  <style scoped>
  /* You can add additional styles here if necessary */
  </style>
  