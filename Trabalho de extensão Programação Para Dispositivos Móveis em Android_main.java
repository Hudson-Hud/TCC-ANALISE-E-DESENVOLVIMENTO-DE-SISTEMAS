
// 1. MainActivity.java

package com.example.churchevents;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar lista de eventos
        eventList = new ArrayList<>();
        loadEvents(); // Método para carregar os eventos

        // Configurar o adaptador
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);
    }

    // Método para carregar eventos (exemplo)
    private void loadEvents() {
        eventList.add(new Event("Culto de Domingo", "20 de Outubro", "Igreja Luzia"));
        eventList.add(new Event("Estudo Bíblico", "22 de Outubro", "Sala 3"));
        eventList.add(new Event("Encontro de Jovens", "25 de Outubro", "Salão Social"));
    }
}


// 2. Event.java (Modelo)

package com.example.churchevents;

public class Event {
    private String name;
    private String date;
    private String location;

    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}

// 3. EventAdapter.java (Adaptador para RecyclerView)

package com.example.churchevents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;

    public EventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.nameTextView.setText(event.getName());
        holder.dateTextView.setText(event.getDate());
        holder.locationTextView.setText(event.getLocation());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView locationTextView;

        public EventViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.event_name);
            dateTextView = itemView.findViewById(R.id.event_date);
            locationTextView = itemView.findViewById(R.id.event_location);
        }
    }
}



// 4. activity_main.xml (Layout da MainActivity)

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginTop="16dp"
        android:padding="8dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>



// 5. event_item.xml (Layout de cada item)

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp">

    <TextView
        android:id="@+id/event_name"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textStyle="bold"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:text="Nome do Evento" />

    <TextView
        android:id="@+id/event_date"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        app:layout_constraintTop_toBottomOf="@id/event_name"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:text="Data do Evento" />

    <TextView
        android:id="@+id/event_location"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="14sp"
        app:layout_constraintTop_toBottomOf="@id/event_date"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:text="Local do Evento" />

</androidx.constraintlayout.widget.ConstraintLayout>


