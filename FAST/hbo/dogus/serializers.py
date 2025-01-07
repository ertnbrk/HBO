from rest_framework import serializers
from .models import Event, Vote

class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = '__all__'

class VoteSerializer(serializers.ModelSerializer):
    class Meta:
        model = Vote
        fields = '__all__'
