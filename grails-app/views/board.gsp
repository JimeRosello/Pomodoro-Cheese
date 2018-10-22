<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Pomodoro & Cheese</title>

</head>
<body>
    <div id="black-screen"></div>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><asset:image class="imageButton" src="configuration.png"/></a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><asset:image class="imageButton" src="profile.png"/></a>
            <ul class="dropdown-menu">
              <li class="dropdown-option"><a href="#">Profile</a></li>
              <li class="dropdown-option"><a href="#">Performance report</a></li>
              <li class="dropdown-option"><a href="/">Log out</a></li>
            </ul>
        </li>
    </content>

    <main>
      <aside>
        <ul class="sideBar">
          <a href="/board"><li class="button">Board</li></a>
          <a href="/start"><li class="button">Start</li></a>
        </ul>
      </aside>

      <section class="board">
              <ul class="boardContent">
                <li class="boardColumn">
                  <h1>To do</h1>
                  <ul class="taskList">
                        <li class="task">
                        </li>
                  </ul>
                </li>
                <li class="boardColumn">
                  <h1>In progress</h1>
                  <ul class="taskList">
                    <li class="task"></li>
                  </ul>
                </li>
                <li class="boardColumn">
                  <h1>Done</h1>
                  <ul class="taskList">

                  </ul>
                </li>
              </ul>
                          <!--          <div id="controllers" role="navigation">
                          <h2>Available Controllers:</h2>
                          <ul>
                              <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                                  <li class="controller">
                                      <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                                  </li>
                              </g:each>
                          </ul>
                        </div>
                      </div>-->
          <a href="#" onclick="openPopup();"><div class="addTaskButton" role="contentinfo">Add task</div></a>
      </section>
    </main>

    <div class="popup">
    </div>

</body>
</html>
