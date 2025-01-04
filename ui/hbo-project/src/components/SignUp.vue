<template>
    <div class="signup">
      <h2>Signup</h2>
      <form @submit.prevent="registerUser">
        <div>
          <label for="email">Email</label>
          <input type="email" v-model="email" id="email" required />
        </div>
        <div>
          <label for="password">Password</label>
          <input type="password" v-model="password" id="password" required />
        </div>
        <div>
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" v-model="confirmPassword" id="confirmPassword" required />
        </div>
        <button type="submit">Sign up</button>
      </form>
      <p>Already have an account? <router-link to="/login">Login</router-link></p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: "",
        password: "",
        confirmPassword: "",
      };
    },
    methods: {
      async registerUser() {
        if (this.password !== this.confirmPassword) {
          alert("Passwords do not match");
          return;
        }
  
        try {
          const response = await this.$axios.post("http://localhost:8080/api/auth/signup", {
            email: this.email,
            password: this.password,
          });
          this.$router.push("/login");
        } catch (error) {
          console.error("Signup error:", error);
          alert("An error occurred during signup");
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Stil ayarları */
  </style>
  