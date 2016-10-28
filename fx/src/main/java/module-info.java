/**
 *
 * @author Thierry Wasylczenko
 * @since
 * @version 1.0
 */
module io.twasyl.demo.fx {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires io.twasyl.demo.core;

    exports io.twasyl.demo.fx;
    //exports io.twasyl.demo.fx.controllers to javafx.fxml;
    exports private io.twasyl.demo.fx.controllers to javafx.fxml;
}