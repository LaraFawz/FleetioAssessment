
# Fleetio Assessment

## Not covered and would be nice to add.

1. Loading animation while search results are loading, and displaying server error messages.
2. Up navigation
3. Offline Support
4. Cover the code with Unit and Instrumentation tests -- Ran out of time.
5. Check for Network Connection
6. Add more animations

## Tech stack & Open-source libraries

- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) based.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Dagger2](https://dagger.dev/) for dependency injection.
- Android Jetpack
    - Lifecycle - dispose of observing data when lifecycle state changes.
    - ViewModel - UI related data holder, lifecycle aware.
    - ViewBinding - write code that interacts with views.
    - DataBinding - bind UI components in layouts to data sources.
    - Navigation - navigate in the app.
    - Paging 3 - render list.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
  
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components.
- [Retrofit2](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
  <br>