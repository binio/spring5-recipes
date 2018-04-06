# spring5-recipes
    public List<ResultDefinition> findByEndDate(final LocalDate date) {
        final javax.persistence.Query query =  entityManager().createNativeQuery(
                "select r.* " +
                        "from result_definition r " +
                        " JOIN ( " +
                        "SELECT id, max(version) as version " +
                        "FROM result_definition c " +
                        "GROUP BY id " +
                        ") AS r2 ON r2.id=r.id AND r2.version=r.version " +
                        "WHERE r.deleted is FALSE AND r.start_date <= :date AND (r.end_date is NULL OR r.end_date >= :date) ", ResultDefinition.class);
                        query.setParameter("date",date);

        List<ResultDefinition> list = (List<ResultDefinition>)query.getResultList();

        return list;
    }
