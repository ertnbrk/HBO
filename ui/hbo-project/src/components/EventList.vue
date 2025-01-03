<template>
    <div class="event-list">
      <h2>Event List</h2>
      <div v-if="events.length">
        <div v-for="event in events" :key="event.id" class="event-item">
          <h3>{{ event.name }}</h3>
          <p>{{ event.date }} | {{ event.location }}</p>
          <router-link :to="'/event/' + event.id">Vote</router-link>
        </div>
      </div>
      <div v-else>
        <p>No events available</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        events: [], // Boş dizi başlangıçta tanımlı

        name: "EventList",
        date: "",
        location: "",
      };
    },
    /*
    async created() {
      try {
        const response = await this.$axios.get("http://localhost:8080/api/events");
        this.events = response.data;
      } catch (error) {
        console.error("Error fetching events:", error);
      }
    },*/
  };
  </script>
  
  <style scoped>
  /* Stil ayarları */
  </style>
  