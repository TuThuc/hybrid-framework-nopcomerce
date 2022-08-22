package environmentConfig;

import org.aeonbits.owner.Config.Key;
@Sources
public interface Environment {
@Key("app.url")
String applicationUrl();
@Key("app.username")
String appUsername();
@Key("app.password")
String appPassword();
}
