package game.view.toolkit.swing.theme;

public class SwingThemeFactoryImpl implements SwingThemeFactory {

    @Override
    public SwingTheme getSwingTheme() {
        return new SwingThemeDefault();
    }

}
