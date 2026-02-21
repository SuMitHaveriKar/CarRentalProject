import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import { AuthProvider } from './context/AuthContext';

import Login from './pages/Login';
import Register from './pages/Register';
import AdminDashboard from './pages/AdminDashboard';
import BookCar from './pages/BookCar';
import MyBookings from './pages/MyBookings';
import Cars from './pages/Cars';

import Checkout from './pages/Checkout';
import Profile from './pages/Profile';
import BookingDetails from './pages/BookingDetails';
import ForgotPassword from './pages/ForgotPassword';

// Main application component managing routes and global auth context
function App() {
  return (
    // Wraps the application to provide authentication state to all components
    <AuthProvider>
      <div className="min-h-screen bg-gray-50">
        <Navbar />

        {/* Define routes for public, protected, and admin pages */}
        <Routes>
          {/* Public Routes */}
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/forgot-password" element={<ForgotPassword />} />
          <Route path="/cars" element={<Cars />} />

          {/* User Protected Routes */}
          <Route path="/book/:carId" element={<BookCar />} />
          <Route path="/booking/:bookingId" element={<BookingDetails />} />
          <Route path="/my-bookings" element={<MyBookings />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/checkout/:bookingId" element={<Checkout />} />

          {/* Admin Protected Routes */}
          <Route path="/admin/dashboard" element={<AdminDashboard />} />
        </Routes>

        <Footer />
      </div>
    </AuthProvider>
  );
}

export default App;
