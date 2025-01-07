from django.urls import path
from .views import CreateEventView, VoteEventView, EventListView

urlpatterns = [
    path('events/', EventListView.as_view(), name='event-list'),
    path('events/create/', CreateEventView.as_view(), name='create-event'),
    path('votes/', VoteEventView.as_view(), name='vote-event'),
]