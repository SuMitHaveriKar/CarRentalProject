import api from './api';

// Creates a new booking
export const createBooking = async (bookingData) => {
    try {
        const response = await api.post('/bookings', bookingData);
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};

// Fetches bookings for the currently logged-in user
export const getMyBookings = async () => {
    try {
        const response = await api.get('/bookings/my-bookings');
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};

export const cancelBooking = async (bookingId) => {
    try {
        const response = await api.put(`/bookings/${bookingId}/cancel`);
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};

export const getAllBookings = async () => {
    try {
        const response = await api.get('/bookings');
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};

// Updates the status of a booking (Admin only)
export const updateBookingStatus = async (bookingId, status) => {
    try {
        const response = await api.put(`/bookings/${bookingId}/status/${status}`);
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};

export const getBookingById = async (bookingId) => {
    try {
        const response = await api.get(`/bookings/${bookingId}`);
        return response.data;
    } catch (error) {
        throw error.response?.data || error.message;
    }
};
