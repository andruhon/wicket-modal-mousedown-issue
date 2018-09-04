### How to reproduce the issue
* Start the application with `gradle appRun` or `.\gradlew.bat appRun`;
* Open the application in the browser;
* Open a modal window by clicking on the "Open the window!" link;
* Open one of Select2 Select or MultiSelect;
* Click anywhere inside of the Modal Window: the select drop does not collapse because `onmousedown="Wicket.Event.stop(event);"` in the `modal.js` swallows it;
* Click anywhere outside of the Modal Window: select drop collapses as expected.

#### Related issues:
* https://issues.apache.org/jira/browse/WICKET-5552
* https://github.com/wicketstuff/core/issues/470