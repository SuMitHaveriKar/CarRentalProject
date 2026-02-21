import api from './api';

// Retrieves payment details associated with a specific booking
export const getPaymentByBookingId = async (bookingId) => {
    try {
        const response = await api.get(`/payments/booking/${bookingId}`);
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};
