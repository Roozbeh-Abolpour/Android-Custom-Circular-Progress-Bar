# Android Custom Circular Progress Bar
A lightweight and customizable circular progress bar for Android applications.

## Features
Smooth circular progress animation
Customizable colors, stroke width, and max progress
Easy integration into any Android project

## Usage
Add the custom ProgressBar to your XML layout:

```xml
<com.example.mycustomview.ProgressBar
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:id="@+id/progress_bar"/>
```

Set or update progress in your activity:

```java
ProgressBar progressBar = findViewById(R.id.progress_bar);
progressBar.setProgress(70); // 70% progress
```

## Customization

You can customize:
- Circle color
- Progress color
- Stroke width
- Maximum progress value
