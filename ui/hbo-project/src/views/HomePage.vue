<template>
  <div>
    <section class="hero">
      <div class="hero-body">
        <div class="container has-text-centered">
          <h1 class="title">Welcome to the Event App!</h1>
          <p class="subtitle">Create events and vote on dates and times with your participants.</p>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container">
        <h2 class="title">How It Works</h2>
        <p>Our platform allows you to create events and vote on dates and times to find the best option for everyone. Start by creating an event, add participants, and let them vote!</p>
        <div class="buttons">
          <router-link to="/create-event" class="button is-primary">Create an Event</router-link>
          <router-link to="/my-events" class="button is-link">My Events</router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
};
</script>

<style scoped>
.hero {
  background: #f5f5f5;
  padding: 3rem 0;
}

.hero .title {
  font-size: 3rem;
}

.hero .subtitle {
  font-size: 1.5rem;
}

.buttons {
  margin-top: 2rem;
}
</style>
