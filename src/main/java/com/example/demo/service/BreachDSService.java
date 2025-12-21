@Service
public class BreachDSService {

    private final BreachRRepository repository;
    private final ShipmentRepository shipmentRepository;

    public BreachDSService(
            BreachRRepository repository,
            ShipmentRepository shipmentRepository) {
        this.repository = repository;
        this.shipmentRepository = shipmentRepository;
    }

    public BreachDSEntity logBreach(
            BreachDSEntity breach,
            Long shipmentId) {

        ShipmentRSEntity shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        breach.setShipment(shipment);
        return repository.save(breach);
    }

    public List<BreachDSEntity> getByShipment(Long shipmentId) {
        return repository.findByShipment_Id(shipmentId);
    }

    public BreachDSEntity resolve(Long id) {
        BreachDSEntity breach = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Breach not found"));

        breach.setResolved(true);
        return repository.save(breach);
    }

    public List<BreachDSEntity> getAll() {
        return repository.findAll();
    }
}
