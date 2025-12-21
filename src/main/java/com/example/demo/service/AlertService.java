@Service
public class AlertService {

    private final AlertRepository repository;
    private final ShipmentRepository shipmentRepository;

    public AlertService(
            AlertRepository repository,
            ShipmentRepository shipmentRepository) {
        this.repository = repository;
        this.shipmentRepository = shipmentRepository;
    }

    public AlertsEntity triggerAlert(
            AlertsEntity alert,
            Long shipmentId) {

        ShipmentRSEntity shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        alert.setShipment(shipment);
        return repository.save(alert);
    }

    public AlertsEntity acknowledgeAlert(Long id) {
        AlertsEntity alert = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Alert not found"));

        alert.setAcknowledged(true);
        return repository.save(alert);
    }

    public List<AlertsEntity> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipment_Id(shipmentId);
    }

    public AlertsEntity getAlertById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Alert not found"));
    }

    public List<AlertsEntity> getAllAlerts() {
        return repository.findAll();
    }
}
