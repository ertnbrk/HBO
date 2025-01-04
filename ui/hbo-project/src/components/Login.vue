<template>
    <div class="login">
      <h2>Login</h2>
      <form @submit.prevent="loginUser">
        <div>
          <label for="email">Email</label>
          <input type="email" v-model="email" id="email" required />
        </div>
        <div>
          <label for="password">Password</label>
          <input type="password" v-model="password" id="password" required />
        </div>
        <button type="submit">Login</button>
      </form>
      <p>Don't have an account? <router-link to="/signup">Sign up</router-link></p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: "",
        password: "",
      };
    },
    methods: {
      async loginUser() {
        try {
          const response = await this.$axios.post("http://localhost:8080/api/auth/login", {
            email: this.email,
            password: this.password,
          });
          // JWT token'ı localStorage'a kaydet
          localStorage.setItem("token", response.data.token);
          this.$router.push("/home");
        } catch (error) {
          console.error("Login error:", error);
          alert("Invalid credentials");
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Stil ayarları */
  </style>
  