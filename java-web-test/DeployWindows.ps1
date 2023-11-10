$CURRENT_DIR = Split-Path -Parent $MyInvocation.MyCommand.Definition
$TARGET_DIR = "$CURRENT_DIR/target"
$RELEASE_JAR_FILE_Filter = 'java-web-test-*.war'
$RELEASE_JAR_FILE = Get-ChildItem -Path "$TARGET_DIR" -Filter $RELEASE_JAR_FILE_Filter

Copy-Item $RELEASE_JAR_FILE.FullName "$TARGET_DIR/java-web-test.war"

scp "$TARGET_DIR/java-web-test.war" ubuntu@124.222.145.48:/usr/local/tomcat/apache-tomcat-10.1.9/webapps/

