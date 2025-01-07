from rest_framework.views import APIView
from rest_framework.response import Response
from .models import Event, Vote
from .serializers import EventSerializer, VoteSerializer

class CreateEventView(APIView):
    def post(self, request):
        # Etkinlik oluşturma işlemi
        serializer = EventSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=201)
        return Response(serializer.errors, status=400)

class VoteEventView(APIView):
    def post(self, request):
        # Oy verme işlemi
        serializer = VoteSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=201)
        return Response(serializer.errors, status=400)
