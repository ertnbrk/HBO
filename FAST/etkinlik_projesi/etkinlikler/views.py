# etkinlikler/views.py
from rest_framework.views import APIView
from rest_framework.response import Response
from .models import Event, EventDate, EventTime, Vote
from .serializers import EventSerializer, VoteSerializer
from rest_framework import status

# Etkinlik Oluşturma API
class CreateEventView(APIView):
    def post(self, request, *args, **kwargs):
        serializer = EventSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


# Oylama API
class VoteEventView(APIView):
    def post(self, request):
        # Oy vermek için gerekli veriler: user_id, event_time_id
        serializer = VoteSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save(user=request.user)
            return Response({"message": "Vote recorded"}, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


# Etkinliklerin Listelenmesi
class EventListView(APIView):
    def get(self, request):
        events = Event.objects.all()
        serializer = EventSerializer(events, many=True)
        return Response(serializer.data)
