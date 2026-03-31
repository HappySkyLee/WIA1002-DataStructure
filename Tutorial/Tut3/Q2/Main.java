package Tutorial.Tut3.Q2;

public class Main {
        /**
     * An interface that describes the operations of an ADT representing
     * a single bid for installing an air conditioning unit.
     */
    public interface BidInterface {

        /**
         * Purpose: Returns the name of the company making this bid.
         * Precondition: The bid has been initialized with a company name.
         * Postcondition: The company name is returned unchanged.
         * * @return A String representing the name of the company.
         */
        String getCompanyName();

        /**
         * Purpose: Returns the description of the air conditioner that this bid is for.
         * Precondition: The bid has been initialized with a description.
         * Postcondition: The description is returned unchanged.
         * * @return A String describing the AC unit.
         */
        String getDescription();

        /**
         * Purpose: Returns the capacity of this bid's AC in tons.
         * Note: 1 ton = 12,000 BTU.
         * Precondition: The capacity has been set for this bid.
         * Postcondition: The capacity in tons is returned unchanged.
         * * @return A double representing the capacity of the AC in tons.
         */
        double getCapacity();

        /**
         * Purpose: Returns the seasonal energy efficiency ratio (SEER) of this bid's AC.
         * Precondition: The SEER value has been set for this bid.
         * Postcondition: The SEER rating is returned unchanged.
         * * @return A double representing the SEER rating.
         */
        double getSEER();

        /**
         * Purpose: Returns the cost of this bid's AC unit.
         * Precondition: The unit cost has been set.
         * Postcondition: The cost of the unit is returned unchanged.
         * * @return A double representing the unit cost.
         */
        double getUnitCost();

        /**
         * Purpose: Returns the cost of installing this bid's AC.
         * Precondition: The installation cost has been set.
         * Postcondition: The cost of installation is returned unchanged.
         * * @return A double representing the installation cost.
         */
        double getInstallationCost();

        /**
         * Purpose: Returns the projected yearly cost of operating this bid's AC.
         * Precondition: The yearly operating cost has been calculated or set.
         * Postcondition: The yearly operating cost is returned unchanged.
         * * @return A double representing the yearly operating cost.
         */
        double getYearlyOperatingCost();
    }

    
        /**
     * An interface that describes the operations of an ADT representing
     * a collection of air conditioning installation bids.
     */
    public interface BidCollectionInterface {

        /**
         * Purpose: Adds a bid to this collection.
         * Precondition: The newBid is a valid, instantiated object implementing BidInterface.
         * Postcondition: The collection contains the newBid. The size of the collection increases by 1.
         * * @param newBid The bid to be added to the collection.
         * @return true if the bid was successfully added, false otherwise.
         */
        boolean addBid(BidInterface newBid);

        /**
         * Purpose: Returns the bid in this collection with the lowest (best) yearly operating cost.
         * Precondition: The collection is not empty.
         * Postcondition: The state of the collection is unchanged. The bid with the lowest yearly cost is returned.
         * * @return The BidInterface object with the best yearly cost, or null if the collection is empty.
         */
        BidInterface getBestYearlyCostBid();

        /**
         * Purpose: Returns the bid in this collection with the lowest (best) initial cost.
         * Initial cost is defined as the unit cost plus the installation cost.
         * Precondition: The collection is not empty.
         * Postcondition: The state of the collection is unchanged. The bid with the lowest initial cost is returned.
         * * @return The BidInterface object with the best initial cost, or null if the collection is empty.
         */
        BidInterface getBestInitialCostBid();

        /**
         * Purpose: Clears all of the bids from this collection.
         * Precondition: None.
         * Postcondition: The collection is empty. The size is 0.
         */
        void clear();

        /**
         * Purpose: Gets the number of bids currently in this collection.
         * Precondition: None.
         * Postcondition: The collection remains unchanged. The current item count is returned.
         * * @return An integer representing the number of bids in the collection.
         */
        int getNumberOfItems();

        /**
         * Purpose: Sees whether this collection is empty.
         * Precondition: None.
         * Postcondition: The collection remains unchanged. Returns true if empty, false otherwise.
         * * @return true if the collection contains no bids, false otherwise.
         */
        boolean isEmpty();
    }
}
