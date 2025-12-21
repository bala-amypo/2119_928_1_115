public interface BreachRRepository
        extends JpaRepository<BreachDSEntity, Long> {

    List<BreachDSEntity> findByShipment_Id(Long shipmentId);
}
