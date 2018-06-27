<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Pomodoro & Cheese</title>
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><asset:image class="imageButton" src="configuration.png"/></a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><asset:image class="imageButton" src="profile.png"/></a>
            <ul class="dropdown-menu">
              <li class="dropdown-option"><a href="#">Profile</a></li><!--Environment: ${grails.util.Environment.current.name}</a></li>-->
              <li class="dropdown-option"><a href="#">Performance report</a></li><!--App profile: ${grailsApplication.config.grails?.profile}</a></li>-->
              <li class="dropdown-option"><a href="/">Log out</a></li>
            </ul>
        </li>
    </content>

    <!--<div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
        </div>
    </div>-->
    <main>
      <aside>
        <ul class="sideBar">
          <a href="/board"><li class="button">Board</li></a>
          <a href="/start"><li class="button">Start</li></a>
        </ul>
      </aside>

      <section class="board"> <!--class="row colset-2-its">-->

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
          <a href="#"><div class="addTaskButton" role="contentinfo">Add task</div></a>
      </section>
    </main>

</body>
</html>
