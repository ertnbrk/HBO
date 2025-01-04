<template>
    <div :class="['container', { 'right-panel-active': isSignUp }]" id="container">
      <div class="form-container sign-up-container">
        <form @submit.prevent="signupUser">
          <h1>Create Account</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <span>or use your email for registration</span>
          <input v-model="signup.name" type="text" placeholder="Name" />
          <input v-model="signup.email" type="email" placeholder="Email" />
          <input v-model="signup.password" type="password" placeholder="Password" />
          <button type="submit">Sign Up</button>
        </form>
      </div>
      <div class="form-container sign-in-container">
        <form @submit.prevent="signinUser">
          <h1>Sign in</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <span>or use your account</span>
          <input v-model="signin.email" type="email" placeholder="Email" />
          <input v-model="signin.password" type="password" placeholder="Password" />
          <a href="#">Forgot your password?</a>
          <button type="submit">Sign In</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <h1>Welcome Back!</h1>
            <p>To keep connected with us please login with your personal info</p>
            <button class="ghost" @click="toggleForm">Sign In</button>
          </div>
          <div class="overlay-panel overlay-right">
            <h1>Hello, Friend!</h1>
            <p>Enter your personal details and start your journey with us</p>
            <button class="ghost" @click="toggleForm">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
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
      },
      signinUser() {
        // Handle user signin logic
        console.log('User signed in:', this.signin);
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
  