package onlineShop.models.products.peripherals;

import onlineShop.models.products.components.BaseComponent;

public class Monitor extends BasePeripheral  {

    public Monitor(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }
}
