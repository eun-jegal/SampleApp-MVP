<h1>MVP Sample App</h1>
<p>
This sample app demonstrates an Android architecture pattern - MVP(Model, View, Presenter) using Coroutines, Retrofit and Dagger2. When the user presses the button on the main screen, the app requests for user datas and displays them in a recyclerView.
</p>
<p align="center">
  <img src="https://user-images.githubusercontent.com/57670625/227792457-50104c7b-b626-4e62-9769-26c3875040a3.gif" width="23%"/>
</p>
<br>

<!-- Tech Stack -->
<h2>Tech Stack</h2>
<ul>
<li>Minumum SDK Level: 21</li>
<li>100% Kotlin</li>
<li>Architecture
    <ul>
      <li>MVP Pattern: One of the most commonly used Android architectural pattern, an alternative to the traditional MVC pattern.</li>
    </ul>
 </li>
<li><a href="https://developer.android.com/kotlin/coroutines">Coroutines</a>: Concurrency design pattern provided by Kotlin</li>
<li><a href="https://square.github.io/retrofit/">Retrofit</a>: Type-safe REST client for Android, Java and Kotlin developed by Square.  </li>
<li><a href="https://square.github.io/okhttp/">OkHttp</a> : 3rd party library sending and receive HTTP-based network requests built on top of the Okio library</li>
<li><a href="https://github.com/google/gson">GSON</a>: Java library that can be used to convert Java Objects into their JSON representation</li>
<li><a href="https://github.com/bumptech/glide">Glide</a>: Fast and efficient open source media management and image loading framework </li>
</ul>
<br>

<!-- MVP Description -->
<h2>What is MVP pattern?</h2>
<p>MVP stands for Model-View-Presenter.</p>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/227793219-0372bcbc-107d-4e27-b2cf-d38f7d3bf5fc.jpg" width="85%"/>
</p>
<ul>
<li><b>Model</b>: Model is a layer for storing data. It is responsible for all business logics and communication with the database and network layers.</li>
<li><b>View</b>: View represents UI layer including activity and fragments. View displays user interfaces and notifies Presenter to keep track of user interactions.</li>
<li><b>Presenter</b>: Presenter gets data from Model and updates UI to display fetched data. It is responsible for managing View states and take actions(ask Model for data) according to the user interaction notifications from View </li>
</ul>
<br>

<h3>MVP flow representation</h3>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/227793218-f39f6f9a-29d0-4596-9d28-ec79025f7bec.jpg" width="85%"/>
</p>
<p>This diagram presents how the app responds within MVP architecture.</p>

<!-- App Architecture -->
<h2>App Architecture</h2>
<p>This sample app was built with MVP pattern.</p>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/228396945-a6f69b5d-730a-4ce4-b1b3-bd4f24124070.jpg" width="85%"/>
</p>
<h3>How MVP works in this app</h3>
<p>The below diagram presents how the app responds according to an user interaction.</p>

<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/228396943-0b57c75d-dbdc-4a69-aff7-06acd19870d7.jpg" width="55%"/>
</p>

<p>1. The user clicks on the "Update data" button on the main screen. Then, View delivers "Intent(User action)" to ViewModel.</p>
<pre><code>binding.apply {
            btnUpdateData.setOnClickListener {
                // Send intent to viewModel
                viewModel.sendIntent(MainIntent.FetchUser)
            }
        }</code></pre>
<p>ViewModel receives Intent from View and send it to "userIntent" channel.</p>
<pre><code>fun sendIntent(intent: MainIntent) {
        viewModelScope.launch {
            userIntent.send(intent)
        }
    }</code></pre>
<p></p>

<p>2. ViewModel performs action(requesting data to repository).</p>
<pre><code>private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }</code></pre>
    
<!-- References -->
<h2>References</h2>
<p>The purpose of this project was to understand the core principles of the MVP pattern. You can check out more information about MVP in following links.</p>
<li><a href="https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/">MVP (Model View Presenter) Architecture Pattern in Android with Example</a></li>
<li><a href="https://medium.com/cr8resume/make-you-hand-dirty-with-mvp-model-view-presenter-eab5b5c16e42">Model View Presenter(MVP) in Android with a simple demo project</a></li>
<li><a href="https://www.kodeco.com/7026-getting-started-with-mvp-model-view-presenter-on-android">Getting Started with MVP (Model View Presenter) on Android</a></li>
<li><a href="https://androidwave.com/android-mvp-architecture-for-beginners-demo-app/">Android MVP Architecture for Beginners (Demo App)</a></li>
