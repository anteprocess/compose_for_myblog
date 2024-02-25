# Compose Related Tips and Sample projects
This repo is for my Medium blog, where I'll be sharing insightful examples and tutorials.

# 1. Basic MVVM for Beginners

Welcome to Basic MVVM for Noobs! This project aims to provide a simple example of the Model-View-ViewModel (MVVM) architecture pattern for beginners.

## Overview

This project demonstrates the implementation of MVVM architecture in an Android app using Kotlin and Jetpack Compose. It features a basic counter functionality where users can increment a counter displayed on the screen.

  ![alt text](https://github.com/anteprocess/compose_for_myblog/blob/main/screenshots/sample.png?raw=true)

## Features

- Incrementing a counter
- Displaying the current count on the screen

## Components

### ViewModel

The `MainScreenViewModel` is responsible for managing the UI-related data and handling user interactions. It updates the UI state based on user actions such as clicking a button to increment the counter.

### Repository

The `CounterRepository` interface defines the contract for accessing and modifying the counter data. It provides methods for getting the current count and incrementing the count.

The `CounterRepositoryImpl` class implements the `CounterRepository` interface. It manages the counter data and provides methods to retrieve and update the count.

### UseCase

The `CounterUseCase` class acts as an intermediary between the ViewModel and the Repository. It encapsulates the business logic for interacting with the counter data. The use case is responsible for orchestrating the interactions between the ViewModel and the Repository.

## How to Use

To use this project, simply clone the repository and open it in Android Studio. Build and run the project on an emulator or physical device.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, feel free to submit a pull request or open an issue.

## License

This project is licensed under the [MIT License](LICENSE).

