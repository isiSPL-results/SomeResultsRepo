@cls
@
@set JAVA_HOME=C:
               \jdk1.6.0_03\
               @set HW_HOME=C:
                            \Users\greenwop\workspace\HealthWatcherOO_06_Factory
                            @
                            @set path=%JAVA_HOME%\bin;
%path%
@set path=%HW_HOME%\bats;
%path%
@
@set classpath=%JAVA_HOME%\lib\tools.jar
               @set classpath=%classpath%;
%JAVA_HOME%\lib\rt.jar
@set classpath=%classpath%;
%HW_HOME%\lib\classes12.zip
@set classpath=%classpath%;
%HW_HOME%\lib\jsdk.jar
@set classpath=%classpath%;
%HW_HOME%\tmp\classes
