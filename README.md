# NewsParser

The JSoup API itself is leveraged for the logical components with but two static helper functions contained in the JSHelp class. The two key features (or design patterns) used in my code are the MVC architectural pattern and dependency injection.

The view is the singleton NewsWriter class. The model is the NewsData class. The controller is mostly coming from JSoup and JSHelp. As this requires the logical modification for each project, the variable components are contained within the user specific main methods. Dependency injection is used throughout to pass constructor or setter based parameterized values that are user specific.
