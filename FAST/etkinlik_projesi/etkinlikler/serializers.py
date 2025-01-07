# etkinlikler/serializers.py
from rest_framework import serializers
from .models import Event, EventDate, EventTime, Vote

class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = '__all__'


class EventDateSerializer(serializers.ModelSerializer):
    class Meta:
        model = EventDate
        fields = '__all__'


class EventTimeSerializer(serializers.ModelSerializer):
    class Meta:
        model = EventTime
        fields = '__all__'


class VoteSerializer(serializers.ModelSerializer):
    class Meta:
        model = Vote
        fields = '__all__'
