<template>
  <div class="calendar-container">
    <FullCalendar
      :plugins="[dayGridPlugin, interactionPlugin]"  
      :initialView="'dayGridMonth'" 
      :events="events"
      @dateClick="handleDateClick"
      @eventClick="handleEventClick"
      :editable="true"
    />
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue3";  // FullCalendar bileşenini import ediyoruz
import dayGridPlugin from "@fullcalendar/daygrid";  // dayGridPlugin import ediyoruz
import interactionPlugin from "@fullcalendar/interaction";  // interactionPlugin import ediyoruz

export default {
  plugins:{
    interactionPlugin,
    dayGridPlugin
  },
  components: {
    FullCalendar,  // Bileşeni tanımlıyoruz
  },
  data() {
    return {
      events: [
        {
          title: "Meeting",
          start: "2025-01-10",
          end: "2025-01-11",
        },
        {
          title: "Conference",
          start: "2025-01-15",
          end: "2025-01-16",
        },
      ],
    };
  },
  methods: {
    handleDateClick(info) {
      alert(`Date clicked: ${info.dateStr}`);  // Tarih tıklama işlemi
    },
    handleEventClick(info) {
      alert(`Event clicked: ${info.event.title}`);  // Etkinlik tıklama işlemi
    },
  },
};
</script>

<style scoped>
.calendar-container {
  max-width: 900px;
  margin: 0 auto;
  padding: 20px;
}
</style>
