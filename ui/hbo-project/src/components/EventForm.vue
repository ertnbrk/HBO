<template>
    <div class="event-form">
      <h2>Create Event</h2>
      <form @submit.prevent="createEvent">
        <div>
          <label for="name">Event Name</label>
          <input type="text" v-model="name" id="name" required />
        </div>
        <div>
          <label for="date">Event Date</label>
          <input type="date" v-model="date" id="date" required />
        </div>
        <div>
          <label for="location">Event Location</label>
          <input type="text" v-model="location" id="location" required />
        </div>
        <button type="submit">Create Event</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        name: "createEvent",
        date: "",
        location: "",
      };
    },
    /*
    methods: {
      async createEvent() {
        try {
          const response = await this.$axios.post("http://localhost:8080/api/events", {
            name: this.name,
            date: this.date,
            location: this.location,
          });
          this.$router.push("/events");
        } catch (error) {
          console.error("Error creating event:", error);
          alert("Failed to create event");
        }
      },
    },*/
  };
  </script>
  
  <style scoped>
  /* Stil ayarları */
  </style>
  