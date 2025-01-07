from django.contrib import admin
from .models import Event, EventDate, EventTime, Vote, Notification

admin.site.register(Event)
admin.site.register(EventDate)
admin.site.register(EventTime)
admin.site.register(Vote)
admin.site.register(Notification)
