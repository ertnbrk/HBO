from django.db import models
from django.contrib.auth.models import User

class Event(models.Model):
    creator = models.ForeignKey(User, on_delete=models.CASCADE)
    name = models.CharField(max_length=255)
    description = models.TextField()
    voting_end_date = models.DateTimeField()

    def __str__(self):
        return self.name


class EventDate(models.Model):
    event = models.ForeignKey(Event, related_name='dates', on_delete=models.CASCADE)
    date = models.DateField()

    def __str__(self):
        return f"{self.event.name} - {self.date}"


class EventTime(models.Model):
    event_date = models.ForeignKey(EventDate, related_name='times', on_delete=models.CASCADE)
    time = models.TimeField()

    def __str__(self):
        return f"{self.event_date.event.name} - {self.time}"


class Vote(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    event_time = models.ForeignKey(EventTime, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Vote by {self.user.username} for {self.event_time.event_date.event.name}"


class Notification(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    event = models.ForeignKey(Event, on_delete=models.CASCADE)
    message = models.TextField()
    sent_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Notification for {self.user.username} - {self.event.name}"
