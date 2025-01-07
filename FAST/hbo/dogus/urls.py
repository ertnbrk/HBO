from django.urls import path
from .views import CreateEventView, VoteEventView

urlpatterns = [
    path('events/', CreateEventView.as_view(), name='create_event'),
    path('votes/', VoteEventView.as_view(), name='vote_event'),
]
